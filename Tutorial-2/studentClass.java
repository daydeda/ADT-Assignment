class studentClass {
    private int sid;
    private String fname;
    private String lname;

    public studentClass(int sid, String fname, String lname) {
        this.sid = sid;
        this.fname = fname;
        this.lname = lname;
    }

    public int getSid() {
        return sid;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
}
