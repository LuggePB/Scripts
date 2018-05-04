package biz.lugge.scripts.rs3.luckykebbit.util;

import java.awt.*;

public class Paint {
    private Image image;
    private int huntedKebbits;
    private int huntedKebbitsPerHour;
    public final Font MAIN_FONT = new Font("Arial", Font.BOLD, 12);
    private int profit = 0;
    private int profitPerHour;
    private int furPrice = 0;
    private String status = "";

    public void drawMouse(Graphics2D g, Point p) {
        int x = (int) p.getX();
        int y = (int) p.getY();

        g.fillOval(x - 10, y, 25, 4);
        g.fillOval(x, y - 10, 4, 25);
    }

    public void refresh(long runtime) {
        setHuntedKebbitsPerHour(getPerHour(getHuntedKebbits(), runtime));
        setProfitPerHour(getPerHour(getProfit(), runtime));
    }

    private int getPerHour(int var, long runtime) {
        return (int) (var * 3600000.0D / runtime);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getHuntedKebbits() {
        return huntedKebbits;
    }

    public void setHuntedKebbits(int huntedKebbits) {
        this.huntedKebbits = huntedKebbits;
    }

    public int getHuntedKebbitsPerHour() {
        return huntedKebbitsPerHour;
    }

    private void setHuntedKebbitsPerHour(int huntedKebbitsPerHour) {
        this.huntedKebbitsPerHour = huntedKebbitsPerHour;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getProfitPerHour() {
        return profitPerHour;
    }

    private void setProfitPerHour(int profitPerHour) {
        this.profitPerHour = profitPerHour;
    }

    public int getFurPrice() {
        return furPrice;
    }

    public void setFurPrice(int furPrice) {
        this.furPrice = furPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
