import java.awt.Color;

public class ImageEditor2 {
	public static Picture threshold(Picture p, int thresh) {
		Picture pic = new Picture(p.width(), p.height());
		for (int i = 0; i < p.width(); i++) {
			for (int j = 0; j < p.height(); j++) {
				if (ImageEditor1.luminance(p.get(i, j)) < thresh) 
					pic.set(i, j, Color.BLACK);
				else
					pic.set(i, j, ImageEditor1.toGrey(p.get(i, j)));
			}
		}
		return pic;
	}
}