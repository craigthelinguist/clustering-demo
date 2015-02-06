package utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageSaver {

	private ImageSaver(){}
	
	public static void save(BufferedImage bi, File file) throws IOException{
		String fpath = file.getAbsolutePath();
		if (fpath.endsWith("jpeg") || fpath.endsWith("jpg")){
			ImageIO.write(bi, "JPEG", file);
		}
		else if (fpath.endsWith("png")){
			ImageIO.write(bi,  "png", file);
		}
		else throw new IOException("Unknown file extension: " + fpath);
	}
	
}
