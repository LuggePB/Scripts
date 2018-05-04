package biz.lugge.scripts.rs3.luckykebbit.util;

public class Time {
    private long lastActionTime;
    private long startTime = 0;

    public String getRuntimeString() {
        final long total_secs = getRuntime() / 1000;
        final long total_mins = total_secs / 60;
        final long total_hrs = total_mins / 60;
        final int secs = (int) total_secs % 60;
        final int mins = (int) total_mins % 60;
        final int hrs = (int) total_hrs % 24;

        return String.format("%02d:%02d:%02d", hrs, mins, secs);
    }

    public long getTimeSinceLastAction() {
        return System.currentTimeMillis() - lastActionTime;
    }

    public long getRuntime() {
        return System.currentTimeMillis() - startTime;
    }

    private void setLastActionTime(long lastActionTime) {
        this.lastActionTime = lastActionTime;
    }

    public void refreshLastActionTime(int crossHairType) {
        if (crossHairType == 1 || crossHairType == 2) {
            setLastActionTime(System.currentTimeMillis());
        }
    }

    public void refreshLastActionTime() {
        setLastActionTime(System.currentTimeMillis());
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
