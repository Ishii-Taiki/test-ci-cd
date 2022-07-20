package mon.web.input;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class InputForm {

    @Size(min=1, message = "氏名は1文字以上で入力してね")
    private String name;

    @NotNull(message = "年齢を入力してね")
    @Range(min=1, max=3, message = "1から3文字で入力してね")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Email(message = "不正な形式です")
    @NotBlank(message="Emailは入力してね")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    private String[] hobby;
}
