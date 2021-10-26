package com.mon.bbn.model;

import com.mon.bbn.utils.Popularity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URI;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "contestants")
public class Contestant {

    // all contestant tags are kept as static values of this class
    public static final String ANGEL  = "angel";
    public static final String BOMA  = "boma";
    public static final String CROSS  = "cross";
    public static final String NIYI  = "niyi";
    public static final String SAGA  = "saga";
    public static final String SAMMIE  = "sammie";
    public static final String YERINS  = "yerins";
    public static final String ARIN  = "arin";
    public static final String BEATRICE  = "beatrice";
    public static final String LIQUOROSE  = "liquorose";
    public static final String PRINCESS  = "princess";
    public static final String NINI  = "nini";
    public static final String SASKAY  = "saskay";
    public static final String TEGA  = "tega";
    public static final String MICHEAL  = "micheal";
    public static final String JMK  = "jmk";
    public static final String KAYVEE  = "kayvee";
    public static final String QUEEN  = "queen";
    public static final String WHITE_MONEY  = "white_money";
    public static final String PEACE  = "peace";
    public static final String PERE  = "pere";
    public static final String MARIA  = "maria";
    public static final String JAY_PAUL  = "jay_paul";
    public static final String JACKIE_B  = "jackie_b";
    public static final String EMMANUEL  = "emmanuel";

    public enum Sex{
        MALE,
        FEMALE
    }

    public enum Status{
        ACTIVE,
        ELIMINATED,
        PROBATION,
    }

    @Id
    // this is the unique identifier of every contestant in the database, and it should be set by mongodb
    private String id;
    private String name;
    private int age;
    private Sex sex;
    private long popularity;
    private long taskCompleted;
    private Status status;
    private String bio;
    private boolean isFavorite;
    private String tag;
    private String state;
    private String imageUri;

    // constructor


    public Contestant(String name, int age, Sex sex, long popularity, long taskCompleted,
                      Status status, String bio, boolean isFavorite, String tag, String state, String imageUri) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.popularity = popularity;
        this.taskCompleted = taskCompleted;
        this.status = status;
        this.bio = bio;
        this.isFavorite = isFavorite;
        this.tag = tag;
        this.state = state;
        this.imageUri = imageUri;
    }
}
