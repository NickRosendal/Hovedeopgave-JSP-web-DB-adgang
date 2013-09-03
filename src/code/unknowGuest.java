package code;

public class unknowGuest
{
	public unknowGuest(String id, String pictureId)
	{
		super();
		this.id = id;
		this.pictureId = pictureId;
	}

	public String getId()
	{
		return id;
	}

	public String getPictureId()
	{
		return pictureId;
	}

	private String id;
	private String pictureId = null;

}
