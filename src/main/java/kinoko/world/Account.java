package kinoko.world;

import kinoko.world.user.AvatarData;

import java.util.List;

public final class Account {
    private final int id;
    private final String username;
    private int slotCount;
    private int nxCredit;
    private int nxPrepaid;
    private int maplePoint;

    // TRANSIENT
    private boolean hasSecondaryPassword = false;
    private int worldId = -1;
    private int channelId = -1;
    private List<AvatarData> characterList;

    public Account(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getSlotCount() {
        return slotCount;
    }

    public void setSlotCount(int slotCount) {
        this.slotCount = slotCount;
    }

    public int getNxCredit() {
        return nxCredit;
    }

    public void setNxCredit(int nxCredit) {
        this.nxCredit = nxCredit;
    }

    public int getNxPrepaid() {
        return nxPrepaid;
    }

    public void setNxPrepaid(int nxPrepaid) {
        this.nxPrepaid = nxPrepaid;
    }

    public int getMaplePoint() {
        return maplePoint;
    }

    public void setMaplePoint(int maplePoint) {
        this.maplePoint = maplePoint;
    }

    // TRANSIENT -------------------------------------------------------------------------------------------------------

    public boolean hasSecondaryPassword() {
        return hasSecondaryPassword;
    }

    public void setHasSecondaryPassword(boolean hasSecondaryPassword) {
        this.hasSecondaryPassword = hasSecondaryPassword;
    }

    public int getWorldId() {
        return worldId;
    }

    public void setWorldId(int worldId) {
        this.worldId = worldId;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public List<AvatarData> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<AvatarData> characterList) {
        this.characterList = characterList;
    }

    public boolean canSelectCharacter(int characterId) {
        return getCharacterList() != null &&
                getCharacterList().stream().anyMatch(avatarData -> avatarData.getCharacterId() == characterId);
    }
}
