grammar html;

html
    :  '<!DOCTYPE html> <html lang="en">' main '</html>' EOF
    ;

main
    :   htmlHead? htmlBody
    ;

htmlHead
    :   '<head>' GLOBAL_STYLE? META? META? META? META? '<title>' RANDOM_TEXT '</title>' '</head>'
    ;

htmlBody
    :   '<body>' mainWrapper SCRIPT?'</body>'
    ;

mainWrapper
    :   '<main>' recursiveContent recursiveContent recursiveContent recursiveContent* SCRIPT?'</main>' | recursiveContent recursiveContent recursiveContent recursiveContent* SCRIPT?
    ;

recursiveContent
    :   RANDOM_TEXT | divWrapper | sectionWrapper | headerWrapper | footerWrapper | divWrapper | sectionWrapper | headerWrapper | footerWrapper | divWrapper | sectionWrapper | headerWrapper | footerWrapper
    ;

divWrapper
    :   '<div 'INLINE_STYLE? FLEX_CLASS?'>' recursiveContent recursiveContent* SCRIPT?'</div>'
    ;

sectionWrapper
    :   '<section 'INLINE_STYLE?'>' recursiveContent recursiveContent* SCRIPT?'</section>'
    ;

headerWrapper
    :   '<header 'INLINE_STYLE?'>' recursiveContent recursiveContent* SCRIPT?'</header>'
    ;

footerWrapper
    :   '<footer 'INLINE_STYLE?'>' recursiveContent recursiveContent* SCRIPT?'</footer>'
    ;



/* Lexer Rules */
OPEN:               '<';
CLOSE:              '>';
OPEN_SLASH:         '</';
SLASH_CLOSE:        '/>';
EQUALS:             '=';
SCRIPT:             '<script>console.log("'RANDOM_TEXT'");</script>';
GLOBAL_STYLE:       '<style>body {margin: 0; font-family: Arial, sans-serif;background-color: #f4f4f4;}</style>';
RANDOM_TEXT:        [a-zA-Z] [a-zA-Z0-9] [a-zA-Z0-9] [a-zA-Z0-9]*;
PX:                 [1-9] [0-9]?'px';
DIM:                [1-9] [0-9]?'%' | PX;
FLEX_CLASS:         'class="flex-container"';

META
    :   '<meta name="viewport" content="width=device-width, initial-scale=1.0">'
    |   '<meta name="description" content="This is a comprehensive example of an HTML head element.">'
    |   '<meta name="author" content="John Doe">'
    |   '<meta name="keywords" content="HTML, head, example, metadata, SEO">'
    |   '<meta http-equiv="X-UA-Compatible" content="IE=edge">'
    |   '<meta name="robots" content="index, follow">'
    |   '<meta property="og:title" content="Comprehensive Head Example">'
    |   '<meta property="og:description" content="A detailed example of a well-structured HTML head element.">'
    |   '<meta property="og:image" content="https://example.com/og-image.jpg">'
    |   '<meta property="og:url" content="https://example.com">'
    |   '<meta name="twitter:card" content="summary_large_image">'
    |   '<meta name="theme-color" content="#ffffff">'
    ;

INLINE_STYLE:       'style="' WIDTH_STYLE? HEIGHT_STYLE? COLOR_STYLE? POSITION_STYLE? BORDDER_STYLE? '"';

WIDTH_STYLE:        'width: 'DIM';';
HEIGHT_STYLE:       'height: 'DIM';';

COLOR:              'red'|'blue'|'green'|'yellow'|'black';
COLOR_STYLE:        'color:' COLOR ';';

POSITION:           'static'|'relative'|'absolute'|'fixed'|'sticky';
POS_DISTANCE_TYPE:  'top'|'left'|'right'|'bottom';
POS_DISTANCE:       POS_DISTANCE_TYPE ':' PX ';';
POSITION_STYLE
    :   'position:' POSITION ';' POS_DISTANCE* | POS_DISTANCE POS_DISTANCE? POS_DISTANCE? POS_DISTANCE?;

BORDER_TYPE: 'solid' | 'dotted' | 'dashed';
BORDER_RADIUS: 'border-radius: '[0-9]'px;';
BORDDER_STYLE: 'border: '[1-9]'px ' BORDER_TYPE ' ' COLOR ';' BORDER_RADIUS;

