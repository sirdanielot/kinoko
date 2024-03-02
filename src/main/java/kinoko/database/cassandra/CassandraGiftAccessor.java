package kinoko.database.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.type.codec.registry.CodecRegistry;
import kinoko.database.GiftAccessor;
import kinoko.database.cassandra.table.GiftTable;
import kinoko.server.cashshop.Gift;
import kinoko.world.item.Item;

import java.util.ArrayList;
import java.util.List;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.*;

public final class CassandraGiftAccessor extends CassandraAccessor implements GiftAccessor {
    public CassandraGiftAccessor(CqlSession session, String keyspace) {
        super(session, keyspace);
    }

    @Override
    public List<Gift> getGiftsByAccountId(int accountId) {
        final List<Gift> gifts = new ArrayList<>();
        final ResultSet selectResult = getSession().execute(
                selectFrom(getKeyspace(), GiftTable.getTableName())
                        .columns(
                                GiftTable.ITEM,
                                GiftTable.SENDER_NAME,
                                GiftTable.MESSAGE
                        )
                        .whereColumn(GiftTable.RECEIVER_ID).isEqualTo(literal(accountId))
                        .build()
        );
        for (Row row : selectResult) {
            final Item item = row.get(GiftTable.ITEM, Item.class);
            final Gift gift = new Gift(
                    item,
                    row.getString(GiftTable.SENDER_NAME),
                    row.getString(GiftTable.MESSAGE)
            );
            gifts.add(gift);
        }
        return gifts;
    }

    @Override
    public boolean hasGift(int accountId) {
        final ResultSet selectResult = getSession().execute(
                selectFrom(getKeyspace(), GiftTable.getTableName())
                        .columns(
                                GiftTable.RECEIVER_ID
                        )
                        .whereColumn(GiftTable.RECEIVER_ID).isEqualTo(literal(accountId))
                        .build()
        );
        for (Row row : selectResult) {
            final int receiverId = row.getInt(GiftTable.RECEIVER_ID);
            if (receiverId == accountId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean newGift(Gift gift, int receiverId) {
        final CodecRegistry registry = getSession().getContext().getCodecRegistry();
        final ResultSet updateResult = getSession().execute(
                update(getKeyspace(), GiftTable.getTableName())
                        .setColumn(GiftTable.ITEM_SN, literal(gift.getItemSn()))
                        .setColumn(GiftTable.RECEIVER_ID, literal(receiverId))
                        .setColumn(GiftTable.ITEM, literal(gift.getItem(), registry))
                        .setColumn(GiftTable.SENDER_NAME, literal(gift.getSender()))
                        .setColumn(GiftTable.MESSAGE, literal(gift.getMessage()))
                        .whereColumn(GiftTable.ITEM_SN).isEqualTo(literal(GiftTable.ITEM_SN))
                        .build()
        );
        return updateResult.wasApplied();
    }

    @Override
    public boolean deleteGift(Gift gift) {
        final ResultSet updateResult = getSession().execute(
                deleteFrom(getKeyspace(), GiftTable.getTableName())
                        .whereColumn(GiftTable.ITEM_SN).isEqualTo(literal(gift.getItemSn()))
                        .build()
        );
        return updateResult.wasApplied();
    }
}
