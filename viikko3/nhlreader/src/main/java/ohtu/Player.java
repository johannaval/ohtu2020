
package ohtu;

public class Player implements Comparable<Player> {

    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setTeam(String team) {

        this.team = team;
    }

    public String getTeam() {

        return team;
    }

    public void setNationality(String nationality) {

        this.nationality = nationality;
    }

    public String getNationality() {

        return nationality;
    }

    public void setGoals(int goals) {

        this.goals = goals;
    }

    public int getGoals() {

        return goals;
    }

    public void setAssists(int assists) {

        this.assists = assists;
    }

    public int getAssists() {

        return assists;
    }


    @Override
    public String toString() {

        return name + getNationality() + " " + getGoals() + " + " + getAssists() + " = " + (getGoals()+getAssists());
    }

    @Override
    public int compareTo(Player player) {

        int goals = player.getGoals() - this.getGoals();
        int assists = player.getAssists() - this.getAssists();

        if (goals==0){
            return assists;
        } else {
            return goals;
        }
    }
}
