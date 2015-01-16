<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>
	
	<xsl:template match="/usecase">


		\subsection{<xsl:value-of select="titolo"/>}

		<xsl:apply-templates select="immagine"/>

		\begin{itemize}
		<xsl:apply-templates select="attorip"/>
		<xsl:apply-templates select="attoris"/>
		<xsl:apply-templates select="generalizzazionedi"/>
		<xsl:apply-templates select="specializzazionedi"/>
		<xsl:apply-templates select="inclusioni"/>
		<xsl:apply-templates select="estensioni"/>
		<xsl:apply-templates select="precondizione"/>
		<xsl:apply-templates select="postcondizione"/>
		<xsl:apply-templates select="scenariop"/>
		<xsl:apply-templates select="scenarioa"/>
		\end{itemize}

	</xsl:template>

	<xsl:template match="immagine">
		\begin{figure}[H]
			\centering
			\Huge{IMMAGINE} \\
			\Large{Da Fare}
			\caption{<xsl:value-of select="//titolo"/>}
		\end{figure}
	</xsl:template>

	<xsl:template match="attorip">
		\item \textbf{Attori principali:} <xsl:value-of select="."/>
	</xsl:template>

	<xsl:template match="attoris">
		\item \textbf{Attori secondari:} <xsl:value-of select="."/>
	</xsl:template>

	<xsl:template match="generalizzazionedi">
		\item \textbf{Generalizzazione di:} <xsl:value-of select="."/>
	</xsl:template>

	<xsl:template match="specializzazionedi">
		\item \textbf{Specializzazione di:} <xsl:value-of select="."/>
	</xsl:template>

	<xsl:template match="inclusioni">
		\item \textbf{Inclusioni:} <xsl:value-of select="."/>
	</xsl:template>

	<xsl:template match="estensioni">
		\item \textbf{Estensioni:} <xsl:value-of select="."/>
	</xsl:template>

	<xsl:template match="precondizione">
		\item \textbf{Precondizione:} <xsl:value-of select="."/>
	</xsl:template>

	<xsl:template match="postcondizione">
		\item \textbf{Postcondizione:} <xsl:value-of select="."/>
	</xsl:template>

	<xsl:template match="scenariop">
		\item \textbf{Scenario principale}

		\begin{enumerate}

		<xsl:for-each select="item">

			\item <xsl:value-of select="."/>

		</xsl:for-each>

		\end{enumerate}

	</xsl:template>

	<xsl:template match="scenarioa">
		\item \textbf{Scenario alternativo}	<xsl:value-of select="."/>
	</xsl:template>
	

</xsl:stylesheet>
