import java.awt.Color;

public class ImageEditor1 {
	public static double luminance(Color color) {
		return 0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue();
	}
	
	public static Color toGrey(Color color) {
		int luminance = (int)Math.round(luminance(color));
		return new Color(luminance, luminance, luminance);
	}
	
	public static Picture makeGreyscale(Picture pic) {
		Picture p = new Picture(pic.width(), pic.height());
		for (int i = 0; i < pic.width(); i++) {
			for (int j = 0; j < pic.height(); j++) {
				p.set(i, j, toGrey(pic.get(i, j)));
			}
		}
		return p;
	}
	
	public static void main(String[] args) {
		Picture p = new Picture("lion2.jpg"); // or use any other colour image
		Picture greyscale = makeGreyscale(p);
		greyscale.show();
	}
}
