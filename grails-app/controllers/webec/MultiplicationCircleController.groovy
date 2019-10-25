package webec

class MultiplicationCircleController {
    static int radius = 200
    static int cx = radius
    static int cy = radius

    def index(MultiplicationCircleModel circleModel) {
        radius = cx = cy = circleModel.radius;
        circleModel.lines = []
        for(int i = 0; i< circleModel.segmentCount; i++) {
            circleModel.lines.add( new Line (
                x1: xValueOf(i, circleModel.segmentCount, circleModel.radius),
                y1: yValueOf(i, circleModel.segmentCount, circleModel.radius),
                x2: xValueOf(i * circleModel.segmentBase, circleModel.segmentCount, circleModel.radius),
                y2: yValueOf(i * circleModel.segmentBase, circleModel.segmentCount, circleModel.radius)
            ))
        }
        render view:"show", model:[circleInstance: circleModel]
    }

    private static double arc(int segment, int segmentCount) {
        2 * Math.PI * segment / segmentCount
    }
    def xValueOf(int segment, int segmentCount, int radius) {
        return cx + Math.cos(arc(segment, segmentCount)) * radius
    }
    def yValueOf(int segment, int segmentCount, int radius) {
        return cy + Math.sin(arc(segment, segmentCount)) * radius
    }
}

class MultiplicationCircleModel {
    int segmentCount = 10
    int segmentBase = 2
    int radius = 200

    List<Line> lines = Collections.EMPTY_LIST
}

class Line {
    double x1, y1, x2, y2
}
