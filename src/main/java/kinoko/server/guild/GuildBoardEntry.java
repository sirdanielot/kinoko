package kinoko.server.guild;

import kinoko.server.packet.OutPacket;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class GuildBoardEntry {
    private final int entryId;
    private final int characterId;
    private String title;
    private String text;
    private Instant date;
    private int emoticon;
    private List<GuildBoardComment> comments;
    private AtomicInteger commentSnCounter;

    public GuildBoardEntry(int entryId, int characterId, String title, String text, Instant date, int emoticon) {
        this.entryId = entryId;
        this.characterId = characterId;
        this.title = title;
        this.text = text;
        this.date = date;
        this.emoticon = emoticon;
        this.comments = new ArrayList<>();
        this.commentSnCounter = new AtomicInteger(1);
    }

    public int getEntryId() {
        return entryId;
    }

    public int getCharacterId() {
        return characterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public int getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(int emoticon) {
        this.emoticon = emoticon;
    }

    public List<GuildBoardComment> getComments() {
        return comments;
    }

    public void setComments(List<GuildBoardComment> comments) {
        this.comments = comments;
    }

    public AtomicInteger getCommentSnCounter() {
        return commentSnCounter;
    }

    public void setCommentSnCounter(AtomicInteger commentSnCounter) {
        this.commentSnCounter = commentSnCounter;
    }

    public void encodeList(OutPacket outPacket) {
        // CUIGuildBBS::ENTRYLIST
        outPacket.encodeInt(entryId); // nEntryID
        outPacket.encodeInt(characterId); // nCharacterID
        outPacket.encodeString(title); // sTitle
        outPacket.encodeFT(date); // ftDate
        outPacket.encodeInt(emoticon); // nEmoticon
        outPacket.encodeInt(comments.size()); // nComments
    }

    public void encodeCurrent(OutPacket outPacket) {
        // CUIGuildBBS::CURENTRY
        outPacket.encodeInt(entryId); // nCurEntryID
        outPacket.encodeInt(characterId); // nCurCharacterID
        outPacket.encodeFT(date); // ftCurDate
        outPacket.encodeString(title); // sCurTitle
        outPacket.encodeString(text); // sCurText
        outPacket.encodeInt(emoticon); // nEmoticon
        outPacket.encodeInt(comments.size()); // nComments
        for (GuildBoardComment comment : comments) {
            comment.encode(outPacket); // CUIGuildBBS::COMMENT
        }
    }
}
