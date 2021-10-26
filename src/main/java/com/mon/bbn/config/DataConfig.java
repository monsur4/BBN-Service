package com.mon.bbn.config;

import com.mon.bbn.model.Contestant;
import com.mon.bbn.repository.ContestantRepository;
import com.mon.bbn.utils.Popularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    private String loremIpsumText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

    @Value("${image.base.url}")
    private String baseImageUrl;

    @Autowired
    ContestantRepository repository;

    /*@Bean
    public CommandLineRunner initializeData() {
        return args -> {
            repository.save(new Contestant("Boma", 34, Contestant.Sex.MALE, 60, 40,
                    Contestant.Status.ACTIVE, loremIpsumText, false, Contestant.BOMA, "Rivers, Nigeria",
                    getCircularImageUrl(Contestant.BOMA) ));

            repository.save(new Contestant("Saskay", 22, Contestant.Sex.FEMALE, 66, 50,
                    Contestant.Status.ELIMINATED, loremIpsumText, true, Contestant.SASKAY, "Adamawa, Nigeria",
                    getCircularImageUrl(Contestant.SASKAY)));

            repository.save(new Contestant("WhiteMoney", 29, Contestant.Sex.MALE, 80, 70,
                    Contestant.Status.ACTIVE, loremIpsumText, true, Contestant.WHITE_MONEY, "Enugu, Nigeria",
                    getCircularImageUrl(Contestant.WHITE_MONEY)));

            repository.save(new Contestant("Nini", 27, Contestant.Sex.FEMALE, 88, 76,
                    Contestant.Status.ACTIVE, loremIpsumText, false, Contestant.NINI, "Edo, Nigeria",
                    getCircularImageUrl(Contestant.NINI)));

            repository.save(new Contestant("Angel", 21, Contestant.Sex.FEMALE, 90, 56,
                    Contestant.Status.ACTIVE, loremIpsumText, true, Contestant.ANGEL, "Akwa Ibom, Nigeria",
                    getCircularImageUrl(Contestant.ANGEL)));

            repository.save(new Contestant("Cross", 30, Contestant.Sex.MALE, 90, 56,
                    Contestant.Status.ELIMINATED, loremIpsumText, true, Contestant.CROSS, "Anambra, Nigeria",
                    getCircularImageUrl(Contestant.CROSS)));

            repository.save(new Contestant("Emmanuel", 24, Contestant.Sex.MALE, 60, 52,
                    Contestant.Status.ELIMINATED, loremIpsumText, false, Contestant.EMMANUEL, "Akwa Ibom, Nigeria",
                    getCircularImageUrl(Contestant.EMMANUEL)));

            repository.save(new Contestant("Liquorose", 26, Contestant.Sex.FEMALE, 76, 72,
                    Contestant.Status.ACTIVE, loremIpsumText, true, Contestant.LIQUOROSE, "Edo, Nigeria",
                    getCircularImageUrl(Contestant.LIQUOROSE)));

            repository.save(new Contestant("Saga", 28, Contestant.Sex.MALE, 86, 78,
                    Contestant.Status.ACTIVE, loremIpsumText, true, Contestant.SAGA, "Lagos, Nigeria",
                    getCircularImageUrl(Contestant.SAGA)));

            repository.save(new Contestant("Maria", 29, Contestant.Sex.FEMALE, 64, 63,
                    Contestant.Status.ELIMINATED, "A former Air Hostess", true, Contestant.MARIA, "Imo, Nigeria",
                    getCircularImageUrl(Contestant.MARIA)));

            repository.save(new Contestant("Peace", 26, Contestant.Sex.FEMALE, 54, 78,
                    Contestant.Status.ELIMINATED, loremIpsumText, false, Contestant.PEACE, "Rivers, Nigeria",
                    getCircularImageUrl(Contestant.PEACE)));

        };
    }*/

    private String getCircularImageUrl(String tag){
        return baseImageUrl + tag + "_circle.png";
    }
}
