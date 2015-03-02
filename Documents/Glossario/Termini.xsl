<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>

	<xsl:template match="/terms">
		
		<xsl:call-template name="character">
			<xsl:with-param name="char">A</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">B</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">C</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">D</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">E</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">F</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">G</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">H</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">I</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">J</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">K</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">L</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">M</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">N</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">O</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">P</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">Q</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">R</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">S</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">T</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">U</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">V</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">W</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">X</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">Y</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="character">
			<xsl:with-param name="char">Z</xsl:with-param>
		</xsl:call-template>


	</xsl:template>


	<xsl:template name="character">
		<xsl:param name="char"/>


		<xsl:if test="entry[starts-with(@name,$char)]">
			
			\newpage

			{\Huge \textbf{<xsl:value-of select="$char"/>}} \\ [1mm]
			
			\hrule

			\begin{description}

			<xsl:apply-templates select="entry[starts-with(@name,$char)]">
				<xsl:sort/>
			</xsl:apply-templates>

			\end{description}

			\vspace{4mm}
		</xsl:if>

	</xsl:template>

	<xsl:template match="entry">
		\item[<xsl:value-of select="@name"/>]
		<xsl:value-of select="."/>

	</xsl:template>

	
</xsl:stylesheet>
