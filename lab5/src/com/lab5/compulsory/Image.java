package com.lab5.compulsory;

import com.lab5.exceptions.InvalidImageFileException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Image extends Item implements Playable{

    public Image(String path) throws InvalidImageFileException {
        super(path);
        if (isPlayable(path))
            throw new InvalidImageFileException("Invalid file format exception. The file is not an image");
    }

    @Override
    public boolean isPlayable(String str) {
        String regex
                = "([^\\s]+(\\.(?i)(jpe?g|png))$)";
        Pattern p = Pattern.compile(regex);

        if (str == null) {
            return true;
        }

        Matcher m = p.matcher(str);
        return !m.matches();
    }
}
