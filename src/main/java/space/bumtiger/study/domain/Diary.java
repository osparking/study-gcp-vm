package space.bumtiger.study.domain;

public class Diary {
	private int sno;
	private String title;
	private String content;
	private String studyDate;
	private short durationMin;

	public Diary(int sno, String title, String content, String studyDate,
			short durationMin) {
		super();
		this.sno = sno;
		this.title = title;
		this.content = content;
		this.studyDate = studyDate;
		this.durationMin = durationMin;
	}

	public Diary(String title, String content, String studyDate,
			short durationMin) {
		super();
		this.title = title;
		this.content = content;
		this.studyDate = studyDate;
		this.durationMin = durationMin;
	}

	public Diary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diary(String title, String content, String studyDate) {
		super();
		this.title = title;
		this.content = content;
		this.studyDate = studyDate;
	}

	/**
	 * @return the sno
	 */
	public int getSno() {
		return sno;
	}

	/**
	 * @param sno the sno to set
	 */
	public void setSno(int sno) {
		this.sno = sno;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the studyDate
	 */
	public String getStudyDate() {
		return studyDate;
	}

	/**
	 * @param studyDate the studyDate to set
	 */
	public void setStudyDate(String studyDate) {
		this.studyDate = studyDate;
	}

	/**
	 * @return the durationMin
	 */
	public short getDurationMin() {
		return durationMin;
	}

	/**
	 * @param durationMin the durationMin to set
	 */
	public void setDurationMin(short durationMin) {
		this.durationMin = durationMin;
	}

}
