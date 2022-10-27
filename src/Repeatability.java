public enum Repeatability {
    single("единоразовая"),
    daily("ежедневная"),
    weekly("еженедельная"),
    monthly("ежемесячная"),
    annual("ежегодная");
    final String info;

    Repeatability(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}