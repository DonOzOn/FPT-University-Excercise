<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : sample.xsl
    Created on : June 4, 2019, 2:38 PM
    Author     : Don OzOn
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="breakfast_menu">
        <html>
            <head>
                <link href="sample.css" rel="stylesheet" type="text/css"/>
                <title>Breakfast list!</title>
            </head>
            <body >
                <h1>Breakfast list!</h1>
                <xsl:for-each select="food">
                    <xsl:sort select="name"/>
                    <p class = "contain-header">
                        <span class="name">
                            <xsl:value-of select="name"/>
                        </span> 
                        <span> - </span>
                        <xsl:value-of select="price"/>
                    </p>
                    <div class = "content">
                        <p class = "descrip">                    
                            <xsl:value-of select="description"/>
                            <span> - </span>
                        </p>
                    
                        <p class = "calo">                        
                            <xsl:choose>
                                <xsl:when test="calories &lt; 651">
                                    <p  style ="font-style : italic"> 
                                        <xsl:value-of select="calories"/>
                                        <span>(calories per serving)</span>
                                    </p>
                                </xsl:when>
                                <xsl:otherwise>
                                    <p  style ="font-style : italic ; color : red"> 
                                        <xsl:value-of select="calories"/>
                                        <span>(Very high calories)</span>
                                    </p>
                                   
                                </xsl:otherwise>
                               
                            </xsl:choose>
                          
                          
                        </p>
                    </div>

                </xsl:for-each>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
