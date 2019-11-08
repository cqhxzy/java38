package game.player;

import game.poker.Poker;

/**
 * 玩家
 * @author Administrator
 *
 */
public abstract class Player {
	//昵称
	private String nickName;

	//玩家的手牌
	private Poker[] hands;
	
	public String getNickName() {
		return nickName;
	}

	public Poker[] getHands() {
		return hands;
	}

	public void setHands(Poker[] hands) {
		this.hands = hands;
	}

	public Player(String nickName) {
		super();
		this.nickName = nickName;
	}

    /**
     * 产生玩家
     * @param names
     * @return
     */
	public static Player[] getPlayers(String[] names){
        int index = (int)(Math.random() * names.length);
        Player[] players = new Player[names.length];
        for (int i = 0; i < players.length; i++) {
            if (i == index) {
                players[i] = new Lord(names[i]);
                continue;
            }
            players[i] = new Farmer(names[i]);
        }
        return players;
    }
}
