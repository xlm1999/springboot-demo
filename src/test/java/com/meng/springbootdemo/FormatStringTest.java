package com.meng.springbootdemo;

public class FormatStringTest {
    String s = "SELECT " +
            " T .CONTRACT_ID, " +
            " T .indicator_name, " +
            " T .score, " +
            " T .weight, " +
            " T .weight_score, " +
            " T .second_score, " +
            " T .create_time, " +
            " t2.truename createUser, " +
            " T1.TRUENAME dutyUser " +
            "FROM " +
            " TB_CONTRACT_INDICATOR T " +
            "LEFT JOIN T_SYS_EMP t1 ON t1.USERID = T .DUTY_USER_ID " +
            "LEFT JOIN T_SYS_EMP t2 ON t2.USERID = T .create_user_id";
}
