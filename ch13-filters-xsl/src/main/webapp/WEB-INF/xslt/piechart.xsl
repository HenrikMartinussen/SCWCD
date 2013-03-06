<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes"/>
  <xsl:template match="/">

    <html xmlns="http://www.w3.org/1999/xhtml">
      <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
        <title>
          Google Visualization API Sample
        </title>
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script type="text/javascript">
          google.load('visualization', '1');
        </script>
        <script type="text/javascript">
          function getData(){
          	var data = new google.visualization.DataTable();
			data.addColumn('string', 'Title');
			data.addColumn('number', 'price');
			<xsl:for-each select="bookstore/book">
			data.addRow(['<xsl:value-of select="title"/>', <xsl:value-of select="price"/>]);
			</xsl:for-each>
  			return data; 
          }
          
          function drawVisualization() {
            var wrapper = new google.visualization.ChartWrapper({
              chartType: 'PieChart',
              dataTable: getData(),
              options: {'title': 'Books, price comparison'},
              containerId: 'visualization'
            });
            wrapper.draw();
          }

          google.setOnLoadCallback(drawVisualization);
        </script>
      </head>
      <body style="font-family: Arial;border: 0 none;">
        <div id="visualization" style="width: 600px; height: 400px;"></div>
      </body>
    </html>
        
  </xsl:template>
</xsl:stylesheet>
