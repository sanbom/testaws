PDFJS.workerSrc = 'http://seikichi.github.io/tmp/PDFJS.0.8.715/pdf.min.worker.js';

$(function () {
    var pdfData = loadPDFData();

    PDFJS.getDocument(pdfData).then(function (pdf) {
        return pdf.getPage(1);
    }).then(function (page) {
        var scale = 1;
        var viewport = page.getViewport(scale);
        var $canvas = $('#the-canvas');
        var canvas = $canvas.get(0);
        var context = canvas.getContext("2d");
        canvas.height = viewport.height;
        canvas.width = viewport.width;

        var $pdfContainer = $("#pdfContainer");
        $pdfContainer.css("height", canvas.height + "px")
            .css("width", canvas.width + "px");

        var renderContext = {
            canvasContext: context,
            viewport: viewport
        };
        page.render(renderContext);
        setupAnnotations(page, viewport, canvas, $('.annotationLayer'));
    });

    function setupAnnotations(page, viewport, canvas, $annotationLayerDiv) {
        var canvasOffset = $(canvas).offset();
        var promise = page.getAnnotations().then(function (annotationsData) {
            viewport = viewport.clone({
                dontFlip: true
            });

            for (var i = 0; i < annotationsData.length; i++) {
                var data = annotationsData[i];
                var annotation = PDFJS.Annotation.fromData(data);
                if (!annotation || !annotation.hasHtml()) {
                    continue;
                }

                var element = annotation.getHtmlElement(page.commonObjs);
                data = annotation.getData();
                var rect = data.rect;
                var view = page.view;
                rect = PDFJS.Util.normalizeRect([
                rect[0],
                view[3] - rect[1] + view[1],
                rect[2],
                view[3] - rect[3] + view[1]]);
                element.style.left = (canvasOffset.left + rect[0]) + 'px';
                element.style.top = (canvasOffset.top + rect[1]) + 'px';
                element.style.position = 'absolute';

                var transform = viewport.transform;
                var transformStr = 'matrix(' + transform.join(',') + ')';
                CustomStyle.setProp('transform', element, transformStr);
                var transformOriginStr = -rect[0] + 'px ' + -rect[1] + 'px';
                CustomStyle.setProp('transformOrigin', element, transformOriginStr);

                if (data.subtype === 'Link' && !data.url) {
                    // In this example,  I do not handle the `Link` annotations without url.
                    // If you want to handle those links, see `web/page_view.js`.
                    continue;
                }
                $annotationLayerDiv.append(element);
            }
        });
        return promise;
    }
});

function loadPDFData() {
    /*jshint multistr: true */
    var base64pdfData = 'c:\\sandeep\\form16roopali.pdf';

    function base64ToUint8Array(base64) {
        var raw = atob(base64);
        var uint8Array = new Uint8Array(new ArrayBuffer(raw.length));
        for (var i = 0, len = raw.length; i < len; ++i) {
            uint8Array[i] = raw.charCodeAt(i);
        }
        return uint8Array;
    }
    return base64ToUint8Array(base64pdfData);
}