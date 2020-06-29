import java.util.Objects;

/**
 * @author 王富昕
 * Created by EGo1ST
 * Date：Created in 2020/6/29
 * Description:
 */

public class Music {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Music(String name, String singer, Integer num) {
        this.name = name;
        this.singer = singer;
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return Objects.equals(name, music.name) &&
                Objects.equals(singer, music.singer) &&
                Objects.equals(num, music.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, singer, num);
    }

    @Override
    public String toString() {
        return "Music{" +
                "name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", num=" + num +
                ", status=" + status +
                '}';
    }

    public enum Status {
        FREE,
        BUSY
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Music(String name, String singer, Integer num, Status status) {
        this.name = name;
        this.singer = singer;
        this.num = num;
        this.status = status;
    }

    private String name;
    private String singer;
    private Integer num;
    public Status status;
}
