package com.scotlaaaand.demo.Step;

public class Step {
    private String source;
    private String target;
    private String modeOfTransport;
    private String playerName;
    private String playerRole;
    private int stepNumber;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public void setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(String playerRole) {
        this.playerRole = playerRole;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public Step(String source, String target, String modeOfTransport, String playerName, String playerRole, int stepNumber) {
        this.source = source;
        this.target = target;
        this.modeOfTransport = modeOfTransport;
        this.playerName = playerName;
        this.playerRole = playerRole;
        this.stepNumber = stepNumber;
    }

    @Override
    public String toString() {
        if(playerRole.equals("imposter")){
            return playerName + " (" + playerRole + ") has moved from X to X via "+ modeOfTransport;
        }
        return playerName + " (" + playerRole + ") has moved from "+source+" to "+target +" via "+ modeOfTransport;
    }
}
