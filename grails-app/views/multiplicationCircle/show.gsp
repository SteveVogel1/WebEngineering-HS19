<!doctype html>
<html>
<head>
    <title>Multiplication Circle</title>
    <style>
        circle, line {
            fill: white;
            stroke: rgba(255, 0, 0, 0.7);
            stroke-width: 3px;
        }
        label {
            display: block;
            float: left;
            width: 5em;
        }
    </style>
    <script>
        function increase(valueName) {
            var input = document.getElementById(valueName);
            input.value = parseInt(input.value) + 1 ;
        }

        function decrease(valueName) {
            var input = document.getElementById(valueName);
            input.value = parseInt(input.value) - 1 ;
        }

    </script>
</head>
<body>
    <form action="/multiplicationCircle/index">
      <tmpl:up_down_input name="segmentCount" label="Segments" value="${circleInstance.segmentCount}" />
      <tmpl:up_down_input name="segmentBase" label="Base" value="${circleInstance.segmentBase}" />
      <tmpl:up_down_input name="radius" label="Radius" value="${circleInstance.radius}" />

    </form>
    <svg width="${circleInstance.radius*2}" height="${circleInstance.radius*2}">
        <circle r="${circleInstance.radius-2}" cx="${circleInstance.radius}" cy="${circleInstance.radius}"/>
        <g:each var="line" in="${circleInstance.lines}">
            <line
                x1="${line.x1}"
                y1="${line.y1}"
                x2="${line.x2}"
                y2="${line.y2}"
                />
        </g:each>
    </svg>

</body>
</html>
