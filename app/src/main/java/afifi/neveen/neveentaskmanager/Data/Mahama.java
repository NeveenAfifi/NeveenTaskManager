package afifi.neveen.neveentaskmanager.Data;

/**
 *فئة تصف مهمة بادارة المهمات
 */
public class Mahama
{
    /**
     * رقم مُميِّز للمهمة يتم انتاجه من قبل الخادم
      */
    private String key;
    /**
     * رقم المميِّز للمستعمل
     */
    private String owner;
    private String title;
    private String Subject;
    private int important;


    public Mahama()
    {

    }

    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return Subject;
    }

    public int getImportant() {
        return important;
    }

    public String getOwner() {
        return owner;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Mahama{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", Subject='" + Subject + '\'' +
                ", important=" + important +
                ", owner='" + owner + '\'' +
                '}';
    }
}
