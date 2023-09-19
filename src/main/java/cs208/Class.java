package cs208;

public class Class
{
    private int id;
    private String code;
    private String title;
    private String description;
    private int maxStudents;

    public Class(String code, String title, String description, int maxStudents)
    {
        this.code = code;
        this.title = title;
        this.description = description;
        this.maxStudents = maxStudents;
    }

    public Class(int id, String code, String title, String description, int maxStudents)
    {
        this(code, title, description, maxStudents);
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getMaxStudents()
    {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents)
    {
        this.maxStudents = maxStudents;
    }

    @Override
    public String toString()
    {
        return "Class{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", maxStudents=" + maxStudents +
                '}';
    }

    /**
     * @return a JSON representation of the object. For example:
     * {
     *   "id": 1,
     *   "code": "CS 410",
     *   "title": "Databases",
     *   "description": "Foundations of database management systems...",
     *   "maxStudents": 10
     * }
     */
    public String toJSON()
    {
        return "{" +
                    "\"id\": " + id + ", " +
                    "\"code\": \"" + code + "\", " +
                    "\"title\": \"" + title + "\", " +
                    "\"description\": \"" + description + "\", " +
                    "\"maxStudents\": " + maxStudents +
                "}";
    }
}
