<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text"/>
  
  <xsl:template match="/document">
    \documentclass[12pt,a4paper]{article}

    %macro definitions
    \newcommand{\groupname}{Kaizen Team}
    \newcommand{\projectname}{Norris}
    \newcommand{\doctitle}{<xsl:value-of select="title"/>}
    \newcommand{\lastversion}{<xsl:value-of select="versions/version[1]/id"/>}
    %\newcommand{\date}[3]{#3-#2-#1}
    %\newcommand{\time}[2]{#1-#2}
    \newcommand{\uri}[1]{\textcolor{blue}{\texttt{#1}}}
    \newcommand{\path}[1]{\texttt{#1}}

    %package include
    \usepackage[margin=2cm]{geometry}
    \usepackage[italian]{babel}
    \usepackage[utf8]{inputenc}
    \usepackage[T1]{fontenc}
    \usepackage{hyperref}
    \usepackage{color}


    %config
    \hypersetup{linktoc=all}
    \setcounter{tocdepth}{5}
    \setcounter{secnumdepth}{5}


    \begin{document}

      <xsl:call-template name="title"/>
      \newpage
      <xsl:call-template name="description"/>
      \newpage
	  <xsl:call-template name="changes"/>
	  \newpage
      \tableofcontents
      \newpage
      \listoftables
      \newpage
      \listoffigures
      \newpage

      <xsl:for-each select="sections/name">
      \input{Sections/<xsl:value-of select="."/>.tex}
      </xsl:for-each>

    \end{document}

  </xsl:template>
  
  <xsl:template name="title">
        \begin{titlepage}
          \begin{center}
            \LARGE{\groupname} \\
            \Large{\projectname} \\
            \Large{\doctitle{}}
          \end{center}
        \end{titlepage}
  </xsl:template>
  
  <xsl:template name="description">
        DESCRIZIONE
  </xsl:template>
  
  <xsl:template name="changes">
        MODIFICHE
  </xsl:template>
  

</xsl:stylesheet>
