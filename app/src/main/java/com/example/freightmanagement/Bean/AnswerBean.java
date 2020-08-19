package com.example.freightmanagement.Bean;

/**
 * Created by songdechuan on 2020/8/18.
 */

public class AnswerBean {
    private String key;

    private String answer;
    private boolean isSelect;

    public boolean getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
