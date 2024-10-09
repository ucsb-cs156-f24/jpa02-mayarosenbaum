package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void testSameObject() {
        Team team1 = new Team("TeamA");
        team1.addMember("Member1");
        team1.addMember("Member2");
        assertEquals(true, team1.equals(team1));
    }

    @Test
    public void testDifferentClassObject() {

        Team team1 = new Team("TeamA");
        String notATeam = "Not a team object";

        assertEquals(false, team1.equals(notATeam));
    }

    @Test
    public void testBothFieldsEqual() {

        Team team1 = new Team("TeamA");
        Team team2 = new Team("TeamA");

        team1.addMember("Member1");
        team1.addMember("Member2");

        team2.addMember("Member1");
        team2.addMember("Member2");

        assertEquals(true, team1.equals(team2));
    }

    @Test
    public void testNameEqualMembersNotEqual() {
        Team team1 = new Team("TeamA");
        Team team2 = new Team("TeamA");

        team1.addMember("Member1");
        team1.addMember("Member2");

        team2.addMember("Member1");
        team2.addMember("Member3");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void testNameNotEqualMembersEqual() {
        Team team1 = new Team("TeamA");
        Team team2 = new Team("TeamB");

        team1.addMember("Member1");
        team1.addMember("Member2");

        team2.addMember("Member1");
        team2.addMember("Member2");

        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void testNameNotEqualMembersNotEqual() {
        Team team1 = new Team("TeamA");
        Team team2 = new Team("TeamB");

        team1.addMember("Member1");
        team1.addMember("Member2");

        team2.addMember("Member3");
        team2.addMember("Member4");

        assertEquals(false, team1.equals(team2));
    }


    @Test
    public void hashCode_returns_correct_hash() {
        Team t = new Team("Team t");
        int result = t.hashCode();
        int expectedResult = -1793847407;
        assertEquals(expectedResult, result);
    }

}
