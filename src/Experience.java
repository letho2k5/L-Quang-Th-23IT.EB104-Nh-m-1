class Experience extends Employee {
    private int expInYear;
    private String proSkill;

    public Experience(String ID, String fullName, String birthDay, String phone, String email, String employeeType, int employeeCount, int expInYear, String proSkill) {
        super(ID, fullName, birthDay, phone, email, employeeType, employeeCount);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Years of Experience: " + expInYear);
        System.out.println("Professional Skill: " + proSkill);
    }
}