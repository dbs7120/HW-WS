package d0813.homework;

import java.util.List;

public interface INewsDAO {
	public List<News> getNewsList();

	public News search(String word);
}
