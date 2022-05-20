/*
 * The idea to build a type-c holder from micro usb holder is
 * 1. cut the micro usb holder into two halves
 * 2. move the cut position 2mm, cut again
 * 3. concat the cut two halves
 * 4. cut the usb hole to make it larger
 */

// Change the variable debugDisplay to false before you export to stl
debugDisplay = true;

// the length to be added, measurement unit is mm
length = 4;

union() {
    // cut 1
    difference() {
        import("./promicro-holder-v3-left-mesh-fixed.stl", convexity=3);

        translate([00, 45, 0]) {
            cube([40, 10, 50]);
        }

        // cut usb hole
        translate([27.3, 18, 19.5]) {
            cube([9.5, 10, 4], center = true);
        }
    }
    // cut 2
    translate([0, length, 0]) {
        difference() {
            import("./promicro-holder-v3-left-mesh-fixed.stl", convexity=3);

            translate([0, 0, 0]) {
                cube([40, 44.9 - length, 50]);
            }
        }
    }
}


////////////////////////////////////////////////////////////////////////////////
// All the code below are just for display.
//
// If you want to change the type-c holder, update the above all wrapped with
// the union() statement.
//
// Change the variable debugDisplay to false before you export to stl
////////////////////////////////////////////////////////////////////////////////

if (debugDisplay) {
    // mimic type-c pro micro board, size is 18mm x 35mm
    color("blue")
        translate([18.3, 15.8, 20]) {
        cube([18, 35, 1]);
    }

    // original holder v3
    translate([40, 0, 0])
        difference() {
        import("./promicro-holder-v3-left-mesh-fixed.stl", convexity=3);
    }

    // mimic micro usb pro micro board, size is 18mm x 33mm
    color("blue")
        translate([58.3, 15.8, 20]) {
        cube([18, 33, 1]);
    }

    // to show type-c holder is 2mm longer than micro usb holder
    color("red")
        translate([35, 50.7, 0]) {
        cube([30, 2, 50]);
    }


    // just to show the cut and concat steps
    // cut 1
    translate([-100, 0, 0])
        difference() {
        import("./promicro-holder-v3-left-mesh-fixed.stl", convexity=3);

        translate([00, 45, 0]) {
            #cube([40, 10, 50]);
        }

        // cut usb hole
        translate([27.3, 13, 19.5]) {
            #cube([9.5, 10, 4], center = true);
        }
    }

    // cut 2
    translate([-50, length, 0])
        difference() {
        import("./promicro-holder-v3-left-mesh-fixed.stl", convexity=3);

        translate([0, 0, 0]) {
            #cube([40, 44.9 - length, 50]);
        }
    }
 }
