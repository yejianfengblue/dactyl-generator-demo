import subprocess, os, re

print("merge manuform images for comparison")

# thumb key count
subprocess.run([
    "montage",
    "-geometry",
    "+0",
    "manuform/manuform-4x6+[2-6]-DIAGONAL.png",
    "manuform/manuform-4x6+x-DIAGONAL-cmp.png"])

# center of the curvature for the column
subprocess.run([
    "montage",
    "-geometry",
    "+0",
    "-tile",
    "4x1",
    "manuform/manuform-4x6+6-(curve.centercol=*)-DIAGONAL.png",
    "manuform/manuform-4x6+6-DIAGONAL.png",
    "manuform/manuform-4x6+6-(curve.centercol)-DIAGONAL-cmp.png"])

for file in os.listdir('manuform'):
    match = re.match(r'manuform-(?P<keys>[\dx+]+)-(?P<param>\(.+\))-(?P<camera>\w+)\.png', file)
    if match:
        baseImg = f"manuform-{match.group('keys')}-{match.group('camera')}.png"
        if "mx-snap-in" in file:
            baseImg = file.replace("mx-snap-in", "mx")
        output = file.replace(".png", "-cmp.png")
        # generate cmp image except for param curve.centercol
        if "curve.centercol" not in file:
            print(f"merge {file} and {baseImg} to {output}")
            subprocess.run([
                "montage",
                "-geometry",
                "+0",
                f"manuform/{file}",
                f"manuform/{baseImg}",
                f"manuform/{output}"])

        # highlight the difference between mx-snap-in and mx
        if "mx-snap-in" in file:
            subprocess.run([
                "convert",
                "-fill",
                "none",
                "-stroke",
                "red",
                "-strokewidth",
                "3",
                "-draw",
                "rectangle 790,470 820,530 rectangle 1790,470 1820,530",
                f"manuform/{output}",
                f"manuform/{output}"])

        # highlight the difference between choc and box
        if "choc" in file:
            subprocess.run([
                "convert",
                "-fill",
                "none",
                "-stroke",
                "red",
                "-strokewidth",
                "3",
                "-draw",
                "rectangle 760,450 800,530 rectangle 1770,450 1810,530",
                f"manuform/{output}",
                f"manuform/{output}"])
