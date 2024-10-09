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
        // Case 1: the same object
        Team team1 = new Team("TeamA");
        team1.addMember("Alice");
        team1.addMember("Bob");

        // This should be true because the object is compared with itself
        assertEquals(true, team1.equals(team1));
    }

    @Test
    public void testDifferentClassObject() {
        // Case 2: The object isn't an instance of Team
        Team team1 = new Team("TeamA");
        String notATeam = "Not a team object";

        // This should be false because the object being compared is not a Team instance
        assertEquals(false, team1.equals(notATeam));
    }

    @Test
    public void testBothFieldsEqual() {
        // Case 3: this.name.equals(other.name) == true && this.members.equals(other.members) == true
        Team team1 = new Team("TeamA");
        Team team2 = new Team("TeamA");

        team1.addMember("Alice");
        team1.addMember("Bob");

        team2.addMember("Alice");
        team2.addMember("Bob");

        // This should be true because both name and members are equal
        assertEquals(true, team1.equals(team2));
    }

    @Test
    public void testNameEqualMembersNotEqual() {
        // Case 3: this.name.equals(other.name) == true && this.members.equals(other.members) == false
        Team team1 = new Team("TeamA");
        Team team2 = new Team("TeamA");

        team1.addMember("Alice");
        team1.addMember("Bob");

        team2.addMember("Alice");
        team2.addMember("Charlie");

        // This should be false because names are equal, but members are not
        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void testNameNotEqualMembersEqual() {
        // Case 3: this.name.equals(other.name) == false && this.members.equals(other.members) == true
        Team team1 = new Team("TeamA");
        Team team2 = new Team("TeamB");

        team1.addMember("Alice");
        team1.addMember("Bob");

        team2.addMember("Alice");
        team2.addMember("Bob");

        // This should be false because names are not equal, even though members are
        assertEquals(false, team1.equals(team2));
    }

    @Test
    public void testNameNotEqualMembersNotEqual() {
        // Case 3: this.name.equals(other.name) == false && this.members.equals(other.members) == false
        Team team1 = new Team("TeamA");
        Team team2 = new Team("TeamB");

        team1.addMember("Alice");
        team1.addMember("Bob");

        team2.addMember("Charlie");
        team2.addMember("Dave");

        // This should be false because both names and members are different
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
