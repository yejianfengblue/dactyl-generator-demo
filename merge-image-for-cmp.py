import os, re

print("merge manuform images for comparison")

for file in os.listdir('manuform'):
    match = re.match(r'manuform-(?P<keys>[\dx+]+)-(?P<param>\[.+\])-(?P<camera>\w+)\.png', file)
    if match:
        baseImg = f"manuform-{match.group('keys')}-{match.group('camera')}.png"
        output = file.replace(".png", "-cmp.png")
        print(f"merge {file} and {baseImg} to {output}")
        os.system(f"montage -geometry +0+0 manuform/{file} manuform/{baseImg} manuform/{output}")
