clc
clear

img = imread("/Users/qayyuma/Documents/GitHub/UHACCS/bruh.jpg");

[Y,X,~] = size(img);
for i = 1:Y
    for j = 1:X
        red = img(i,j,1);
        green = img(i,j,2);
        blue = img(i,j,3);
        img(i,j,:) = uint8(.2126 * red + .7152 * green + .0722 * blue);
    end
end
image(img);


30 30 31 31 31 32 32 34 34 34 35 35 37 37 37 37 39 39 39 39 39 30 31 31 32 32 33 34 34 34 36 35 35 37 37 39 39 39 38 40 42 41 31 30 32 32 33 34 37 37 36 36 39 37 39 40 39 41 40 41 41 41 43 31 33 31 32 33 34 36 37 36 35 36 39 37 37 40 39 38 40 41 42 41 31 31 33 32 32 34 35 35 35 37 37 38 37 41 39 40 39 42 41 41 44 30 32 32 34 34 34 35 35 34 37 35 38 38 37 40 40 38 38 42 42 44 32 32 32 32 34 34 36 36 37 37 38 38 39 41 40 41 41 41 41 44 43 32 32 34 34 34 34 36 38 39 39 39 40 40 41 42 42 41 41 44 44 43 34 34 34 34 34 37 36 37 39 39 40 41 41 42 42 42 43 44 44 44 43 34 34 34 36 33 35 35 39 40 39 40 41 41 42 41 41 44 44 43 45 45 32 36 34 34 37 35 36 39 39 39 41 41 41 41 41 41 41 41 43 43 44 35 34 35 35 35 36 35 37 38 38 40 42 39 42 41 41 44 44 43 44 44 33 34 35 35 37 37 39 39 38 39 41 39 42 40 43 44 44 43 44 44 44 34 34 37 37 37 38 37 38 39 39 41 41 42 43 41 44 43 46 45 45 46 36 36 37 37 39 38 40 38 40 40 41 41 44 41 44 44 45 44 45 46 45 35 35 39 38 38 38 39 41 40 40 42 42 41 41 43 43 45 45 46 46 46 35 35 38 38 38 38 40 40 40 40 42 42 44 41 43 43 45 46 46 46 46 36 36 38 38 38 39 40 40 40 40 42 42 41 43 45 45 45 46 46 46 47 37 37 39 39 38 39 38 40 40 42 42 42 43 44 43 46 46 47 47 47 46 38 39 38 38 41 38 41 40 44 41 43 43 44 45 46 45 46 46 47 46 48 39 39 40 40 38 42 40 42 41 43 43 43 46 44 45 44 46 46 48 48 47