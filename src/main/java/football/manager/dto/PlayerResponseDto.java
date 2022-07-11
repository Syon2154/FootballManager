package football.manager.dto;

public class PlayerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private int experience;
    private TeamResponseDto teamResponseDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public TeamResponseDto getTeamResponseDto() {
        return teamResponseDto;
    }

    public void setTeamResponseDto(TeamResponseDto teamResponseDto) {
        this.teamResponseDto = teamResponseDto;
    }
}
