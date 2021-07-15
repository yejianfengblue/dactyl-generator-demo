import subprocess, os, re

print("merge manuform images for comparison")

subprocess.run([
    "montage",
    "-geometry",
    "+0",
    "manuform/manuform-4x6+[2-6]-DIAGONAL.png",
    "manuform/manuform-4x6+x-DIAGONAL-cmp.png"])

for file in os.listdir('manuform'):
    match = re.match(r'manuform-(?P<keys>[\dx+]+)-(?P<param>\(.+\))-(?P<camera>\w+)\.png', file)
    if match:
        baseImg = f"manuform-{match.group('keys')}-{match.group('camera')}.png"
        if "mx-snap-in" in file:
            baseImg = file.replace("mx-snap-in", "mx")
        output = file.replace(".png", "-cmp.png")
        print(f"merge {file} and {baseImg} to {output}")
        subprocess.run([
            "montage",
            "-geometry",
            "+0",
            f"manuform/{file}",
            f"manuform/{baseImg}",
            f"manuform/{output}"])

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
                "'rectangle 1580,950 1630,1050 rectangle 3580,950 3630,1050'",
                f"manuform/{output}",
                f"manuform/{output}"])

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
                "'rectangle 1520,900 1600,1100 rectangle 3550,900 3630,1100'",
                f"manuform/{output}",
                f"manuform/{output}"])
