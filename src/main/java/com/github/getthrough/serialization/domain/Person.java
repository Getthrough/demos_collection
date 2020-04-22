package com.github.getthrough.serialization.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author getthrough
 * @date 2020/3/12
 */
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = -4172326962616268260L;
    private String name;
    private String gender;
    private int age;
    private String email;
}
