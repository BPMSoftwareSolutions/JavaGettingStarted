package com.company;

public class Passenger implements Comparable<Passenger> {
    private String name;

    public static class RewordProgram {
        private int memberLevel = 1;
        private int memberDays;

        public RewordProgram() {

        }

        public RewordProgram(int memberLevel) {
            this.memberLevel = memberLevel;
        }

        public int getMemberLevel() {
            return memberLevel;
        }

        public void setMemberLevel(int memberLevel) {
            this.memberLevel = memberLevel;
        }

        public int getMemberDays() {
            return memberDays;
        }

        public void setMemberDays(int memberDays) {
            this.memberDays = memberDays;
        }
    }
    private RewordProgram rewordProgram = new RewordProgram();

    public Passenger(String name) {
        this.name = name;
    }

    public Passenger(String name, int memberLevel, int memberDays) {
        this.name = name;
        this.rewordProgram.memberLevel = memberLevel;
        this.rewordProgram.memberDays = memberDays;
    }

    public RewordProgram getRewordProgram() { return this.rewordProgram; }

    @Override
    public int compareTo(Passenger passenger) {
        int returnVal = passenger.rewordProgram.memberLevel - this.rewordProgram.memberLevel;

        if (returnVal == 0) {
            returnVal = passenger.rewordProgram.memberDays - this.rewordProgram.memberDays;
        }

        return returnVal;
    }

    public String getName() {
        return name;
    }
}
