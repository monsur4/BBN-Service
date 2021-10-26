package com.mon.bbn.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection="seasons")
public class Season {

    // this is the unique identifier of every season in the database, and it would be manually set
    @Id
    private final Integer seasonNumber;
    private final int numberOfHousemates;
    private final String winner;
}
