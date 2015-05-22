<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>

	<xsl:variable name="system" select="/XMI/XMI.content/*[local-name()='Model']/@name"/>

	<xsl:template match="/">
		<xsl:apply-templates select="XMI/XMI.content/*[local-name()='Model']/*[local-name()='Namespace.ownedElement']/*[local-name()='Package']"/>
	</xsl:template>

	<!-- package -->
	<xsl:template match="*[local-name()='Package']">
		<xsl:if test="@name!='java' and @name!='Hidden' and @name!='Lib'">

			<xsl:variable name="name">
				<xsl:call-template name="namespace"><xsl:with-param name="id" select="@xmi.id"/></xsl:call-template>
			</xsl:variable>
			\level{3}[<xsl:value-of select="@name"/>]{<xsl:value-of select="$name"/>}
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
			\level{4}[<xsl:value-of select="@name"/>]{<xsl:value-of select="$name"/>}
			<xsl:call-template name="image"><xsl:with-param name="name" select="translate($name,':','-')"/></xsl:call-template>
			
			\begin{itemize}
			\item \textbf{Nome:} <xsl:value-of select="@name"/>
			\item \textbf{Tipo:} classe
			<xsl:call-template name="abstract"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.visibility']"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.stereotype']"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.definition']"/>
			<xsl:apply-templates select="*[local-name()='Classifier.feature']"/>
			\end{itemize}

			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface' or local-name()='Package']"/>
	</xsl:template>

	<!-- interfacce -->
	<xsl:template match="*[local-name()='Interface']">
		<xsl:if test="$system = 'Applicazione'">
			<xsl:variable name="name">
				<xsl:call-template name="namespace"><xsl:with-param name="id" select="@xmi.id"/></xsl:call-template>
			</xsl:variable>
			\level{4}[<xsl:value-of select="@name"/>]{<xsl:value-of select="$name"/>}
			<xsl:call-template name="image"><xsl:with-param name="name" select="translate($name,':','-')"/></xsl:call-template>
			
			\begin{itemize}
			\item \textbf{Nome:} <xsl:value-of select="@name"/>
			\item \textbf{Tipo:} interfaccia
			<xsl:apply-templates select="*[local-name()='ModelElement.visibility']"/>
			<xsl:apply-templates select="*[local-name()='ModelElement.definition']"/>
			<xsl:apply-templates select="*[local-name()='Classifier.feature']"/>
			\end{itemize}

			<xsl:apply-templates select="*[local-name()='Namespace.ownedElement']/*[local-name()='Class' or local-name()='Interface' or local-name()='Package']"/>
		</xsl:if>
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

	<!-- immagini -->
	<xsl:template name="image">
		<xsl:param name="name"></xsl:param>

		\IfFileExists{DefinizioneDiProdotto/Pics/Classi/<xsl:value-of select="$name"/>.pdf}{
			\begin{figure}[H]
				\centering
				\includegraphics[scale=0.5]{DefinizioneDiProdotto/Pics/Classi/<xsl:value-of select="$name"/>}
				\caption{<xsl:value-of select="translate($name,'-',':')"/>}
			\end{figure}
		}
	</xsl:template>

	<!-- estende -->
	<xsl:template match="*[local-name()='GeneralizableElement.generalization']">
		\item \textbf{Estende:}
		<xsl:for-each select="*[local-name()='Generalization']">
			<xsl:call-template name="extends"><xsl:with-param name="id" select="@xmi.idref"/></xsl:call-template><xsl:if test="position() != last()">, </xsl:if>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="extends">
		<xsl:param name="id"></xsl:param>
		<xsl:call-template name="id-name"><xsl:with-param name="id" select="//*[@xmi.id=$id]/*[local-name()='Generalization.parent']/*[local-name()='GeneralizableElement']/@xmi.idref"/></xsl:call-template>
	</xsl:template>

	<!-- implementa -->
	<xsl:template match="*[local-name()='ModelElement.clientDependency']">
		\item \textbf{Implementa:}
		<xsl:for-each select="*[local-name()='Dependency']">
			<xsl:call-template name="implements"><xsl:with-param name="id" select="@xmi.idref"/></xsl:call-template><xsl:if test="position() != last()">, </xsl:if>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="implements">
		<xsl:param name="id"></xsl:param>
		<xsl:call-template name="id-name"><xsl:with-param name="id" select="//*[@xmi.id=$id]/*[local-name()='Dependency.supplier']/*[local-name()='ModelElement']/@xmi.idref"/></xsl:call-template>
	</xsl:template>

	<!-- attributi e metodi -->
	<xsl:template match="*[local-name()='Classifier.feature']">
		<xsl:if test="*[local-name()='Attribute']">
			\item \textbf{Attributi:}
				\begin{itemize}
				\setlength{\itemsep}{5pt}
				<xsl:for-each select="*[local-name()='Attribute']">
					\item[\ding{111}] <xsl:if test="@ownerScope = 'classifier'">\underline</xsl:if>{<xsl:choose>
							<xsl:when test="*[local-name()='Feature.visibility']/@xmi.value = 'public'">+</xsl:when>
							<xsl:when test="*[local-name()='Feature.visibility']/@xmi.value = 'package'">\(\sim\)</xsl:when>
							<xsl:when test="*[local-name()='Feature.visibility']/@xmi.value = 'protected'">\#</xsl:when>
							<xsl:when test="*[local-name()='Feature.visibility']/@xmi.value = 'private'">--</xsl:when>
						</xsl:choose><xsl:value-of select="@name"/> : <xsl:call-template name="id-name">
							<xsl:with-param name="id" select="*[local-name()='StructuralFeature.type']/*[local-name()='Classifier']/@xmi.idref"/>
						</xsl:call-template>}<xsl:if test="*[local-name()='ModelElement.definition']"> \\ [1mm] </xsl:if>
						<xsl:value-of select="translate(*[local-name()='ModelElement.definition']/@xmi.value,'+',' ')"/>
				</xsl:for-each>
				\end{itemize}
		</xsl:if>
		<xsl:if test="*[local-name()='Operation']">
			\item \textbf{Metodi:}
				\begin{itemize}
				\setlength{\itemsep}{5pt}
				<xsl:for-each select="*[local-name()='Operation']">
					\item[\ding{111}] <xsl:if test="@isAbstract='true'">\textit</xsl:if>{<xsl:if test="@ownerScope = 'classifier'">\underline</xsl:if>{<xsl:choose>
							<xsl:when test="*[local-name()='Feature.visibility']/@xmi.value = 'public'">+</xsl:when>
							<xsl:when test="*[local-name()='Feature.visibility']/@xmi.value = 'package'">\(\sim\)</xsl:when>
							<xsl:when test="*[local-name()='Feature.visibility']/@xmi.value = 'protected'">\#</xsl:when>
							<xsl:when test="*[local-name()='Feature.visibility']/@xmi.value = 'private'">--</xsl:when>
						</xsl:choose><xsl:value-of select="@name"/>(<xsl:call-template name="op-parameter"><xsl:with-param name="id" select="@xmi.id"/></xsl:call-template>)<xsl:if test="*[local-name()='BehavioralFeature.parameter']/*[local-name()='Parameter' and @kind='return']/*[local-name()='Parameter.type']/*[local-name()='Classifier']/@xmi.idref"> : </xsl:if><xsl:call-template name="id-name">
							<xsl:with-param name="id" select="*[local-name()='BehavioralFeature.parameter']/*[local-name()='Parameter' and @kind='return']/*[local-name()='Parameter.type']/*[local-name()='Classifier']/@xmi.idref"/>
						</xsl:call-template>}}<xsl:if test="*[local-name()='ModelElement.definition']"> \\ [1mm] </xsl:if>
						<xsl:value-of select="translate(*[local-name()='ModelElement.definition']/@xmi.value,'+',' ')"/>
				</xsl:for-each>
				\end{itemize}
		</xsl:if>
	</xsl:template>

	<!-- nome da id -->
	<xsl:template name="id-name">
		<xsl:param name="id"></xsl:param>

		<xsl:value-of select="//*[@xmi.id = $id]/@name"/>
	</xsl:template>

	<xsl:template name="op-parameter">
		<xsl:param name="id"></xsl:param>
		<xsl:for-each select="*[local-name()='BehavioralFeature.parameter']/*[local-name()='Parameter' and @kind!='return']">
			<xsl:value-of select="@name"/> : <xsl:call-template name="id-name"><xsl:with-param name="id" select="*[local-name()='Parameter.type']/*[local-name()='Classifier']/@xmi.idref"/></xsl:call-template><xsl:if test="position() != last()">, </xsl:if>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>
