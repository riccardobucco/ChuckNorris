<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>

	
	<xsl:template match="/">
		\level{4}{Classi}
		<xsl:apply-templates select="XMI/XMI.content/*[local-name()='Model']/*[local-name()='Namespace.ownedElement']/*[local-name()='Package']"/>
	</xsl:template>

	<!-- package -->
	<xsl:template match="*[local-name()='Package']">
		<xsl:if test="@name!='java' and @name!='Hidden'">

			<xsl:variable name="name">
				<xsl:call-template name="namespace"><xsl:with-param name="id" select="@xmi.id"/></xsl:call-template>
			</xsl:variable>
			\level{5}[<xsl:value-of select="@name"/>]{<xsl:value-of select="$name"/>}
			<xsl:call-template name="image"><xsl:with-param name="name" select="translate($name,':','-')"/></xsl:call-template>

			\begin{itemize}
			\item \textbf{Nome:} <xsl:value-of select="@name"/>
			\item \textbf{Tipo:} package
			\end{itemize}

			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface' or local-name()='Package']"/>
		</xsl:if>
	</xsl:template>

	<!-- classi -->
	<xsl:template match="*[local-name()='Class']">

			<xsl:variable name="name">
				<xsl:call-template name="namespace"><xsl:with-param name="id" select="@xmi.id"/></xsl:call-template>
			</xsl:variable>
			\level{6}[<xsl:value-of select="@name"/>]{<xsl:value-of select="$name"/>}
			
			\begin{itemize}
			\item \textbf{Nome:} <xsl:value-of select="@name"/>
			\item \textbf{Tipo:} classe
			<xsl:call-template name="abstract"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.visibility']"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.stereotype']"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.definition']"/>
			\end{itemize}

			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface' or local-name()='Package']"/>			
	</xsl:template>

	<!-- interfacce -->
	<xsl:template match="*[local-name()='Interface']">

			<xsl:variable name="name">
				<xsl:call-template name="namespace"><xsl:with-param name="id" select="@xmi.id"/></xsl:call-template>
			</xsl:variable>
			\level{6}[<xsl:value-of select="@name"/>]{<xsl:value-of select="$name"/>}
			
			\begin{itemize}
			\item \textbf{Nome:} <xsl:value-of select="@name"/>
			\item \textbf{Tipo:} interfaccia
			<xsl:apply-templates select="*[local-name()='ModelElement.visibility']"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.definition']"/>
			\end{itemize}

			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface' or local-name()='Package']"/>
	</xsl:template>

	<!-- visibilità -->
	<xsl:template match="*[local-name()='ModelElement.visibility']">
			\item \textbf{Visibilità:} <xsl:value-of select="@xmi.value"/>
	</xsl:template>

	<!-- descrizione -->
	<xsl:template match="*[local-name()='ModelElement.definition']">
			\item \textbf{Descrizione:} <xsl:value-of select="translate(@xmi.value,'+',' ')"/>
	</xsl:template>

	<!-- stereotipi -->
	<xsl:template match="*[local-name()='ModelElement.stereotype']">
		\item \textbf{Stereotipi:}
		\begin{itemize}
			<xsl:apply-templates select="*[local-name()='Stereotype']"/>
		\end{itemize}
	</xsl:template>

	<!-- stereotipi -->
	<xsl:template match="*[local-name()='Stereotype']">
		<xsl:param name="id" select="@xmi.idref"/>
		\item <xsl:value-of select="//*[@xmi.id=$id]/@name"/>
	</xsl:template>

	<!-- abstract -->
	<xsl:template name="abstract">
		\item \textbf{Astratta:}
		<xsl:if test="@isAbstract='true'">si</xsl:if>
		<xsl:if test="@isAbstract='false'">no</xsl:if>
	</xsl:template>

	<!-- namespace -->
	<xsl:template name="namespace">
		<xsl:param name="id"></xsl:param>
		
		<xsl:if test="//*[@xmi.id=$id]/@name">
			<xsl:call-template name="namespace">
				<xsl:with-param name="id" select="//*[@xmi.id=$id]/../../@xmi.id"/>
			</xsl:call-template>
			<xsl:if test="//*[@xmi.id=$id]/../../@xmi.id">::</xsl:if>
			<xsl:value-of select="//*[@xmi.id=$id]/@name"/>
		</xsl:if>

	</xsl:template>

	<!-- immagine -->
	<xsl:template name="image">
		<xsl:param name="name"></xsl:param>

		\IfFileExists{SpecificaTecnica/Pics/Classi/<xsl:value-of select="$name"/>.pdf}{
			\begin{figure}[H]
				\centering
				\includegraphics[scale=0.3]{SpecificaTecnica/Pics/Classi/<xsl:value-of select="$name"/>}
				\caption{<xsl:value-of select="translate($name,'-',':')"/>}
			\end{figure}
		}
	</xsl:template>

</xsl:stylesheet>
