package wooteco.subway.admin.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StationsTest {

    private static Stations stations;

    @BeforeAll
    static void initialize() {
        List<Station> tempStation = new ArrayList<>();
        tempStation.add(new Station(1L, "강남"));
        tempStation.add(new Station(2L, "역삼"));
        tempStation.add(new Station(3L, "선릉"));
        tempStation.add(new Station(4L, "삼성"));

        stations = new Stations(tempStation);
    }

    @Test
    @DisplayName("ID로 역 찾아오기 테스트")
    void findStationByIdTest() {
        assertThat(stations.findStationById(1L).getName()).isEqualTo("강남");
        assertThat(stations.findStationById(2L).getName()).isEqualTo("역삼");
        assertThat(stations.findStationById(3L).getName()).isEqualTo("선릉");
        assertThat(stations.findStationById(4L).getName()).isEqualTo("삼성");
    }

    @Test
    @DisplayName("이름으로 역 찾아오기 테스트")
    void findStationByNameTest() {
        assertThat(stations.findStationByName("강남").getId()).isEqualTo(1L);
        assertThat(stations.findStationByName("역삼").getId()).isEqualTo(2L);
        assertThat(stations.findStationByName("선릉").getId()).isEqualTo(3L);
        assertThat(stations.findStationByName("삼성").getId()).isEqualTo(4L);
    }
}
