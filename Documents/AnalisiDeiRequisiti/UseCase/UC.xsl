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
		<xsl:apply-templates select="principale"/>
		<xsl:apply-templates select="alternativi"/>
		\end{itemize}

	</xsl:template>

	<xsl:template match="immagine">
		\begin{figure}[H]
			\centering
			\includegraphics[width=0.5\textwidth]{AnalisiDeiRequisiti/Pics/UseCase/<xsl:value-of select="."/>}
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
		\item \textbf{Generalizzazione di:}
		
		\begin{itemize}
		<xsl:apply-templates select="item"/>
		\end{itemize}

	</xsl:template>

	<xsl:template match="specializzazionedi">
		\item \textbf{Specializzazione di:}

		\begin{itemize}
		<xsl:apply-templates select="item"/>
		\end{itemize}

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
		\item \textbf{Postcondizione:}<xsl:value-of select="."/>
	</xsl:template>

	<xsl:template match="principale">
		\item \textbf{Scenario principale}

		\begin{enumerate}
		<xsl:apply-templates select="item"/>
		\end{enumerate}

	</xsl:template>

	<xsl:template match="alternativi">
		\item \textbf{Scenari alternativi} \\
		<xsl:apply-templates select="scenario"/>
	</xsl:template>

	<xsl:template match="scenario">
		\emph{<xsl:value-of select="descrizione"/>}

		\begin{enumerate}
		<xsl:apply-templates select="item"/>
		\end{enumerate}
	</xsl:template>




	<xsl:template match="item">
		\item <xsl:value-of select="."/>
	</xsl:template>
	

</xsl:stylesheet>
