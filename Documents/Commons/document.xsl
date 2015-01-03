<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text"/>
  
  <xsl:template match="/document">
    \documentclass[12pt,a4paper]{article}

    %macro definitions
    \newcommand{\groupname}{Kaizen Team}
    \newcommand{\projectname}{Norris}
    \newcommand{\fullprojectname}{\projectname : Real-time Business Intelligence}
    \newcommand{\doctitle}{<xsl:value-of select="title"/>}
    \newcommand{\lastversion}{<xsl:value-of select="changes/version[1]/id"/>}
    \newcommand{\insdate}[3]{#3-#2-#1}
    \newcommand{\instime}[2]{#1-#2}
    \newcommand{\uri}[1]{\textcolor{blue}{\texttt{#1}}}
    \newcommand{\path}[1]{\texttt{#1}}
    \newcommand{\role}[1]{\textit{#1}}
    \newcommand{\doc}[1]{\textit{“#1”}}
    \newcommand{\file}[1]{\textit{“#1”}}
    \newcommand{\rev}[1]{\texttt{#1}}
    \newcommand{\phase}[1]{\texttt{#1}}
    \newcommand{\proponente}{Maccagnan Alessandro}
    \newcommand{\committente}{Vardanega Tullio}


    %package include
    \usepackage[margin=2cm]{geometry}
    \usepackage[italian]{babel}
    \usepackage[utf8]{inputenc}
    \usepackage[T1]{fontenc}
    \usepackage{graphicx}
    \usepackage{fancyhdr}
    \usepackage{lastpage}
    \usepackage{tabu}
    \usepackage{hyperref}
    \usepackage{color}


    %config
    \hypersetup{linktoc=all}
    \setcounter{tocdepth}{5}
    \setcounter{secnumdepth}{5}

    %fancyhdr config
    %\lhead{\colorbox{blue}{ciao}}
    %\chead{\colorbox{blue}}
    %\rhead{\colorbox{blue}}
    \lfoot{\doctitle \\ v\lastversion}
    \cfoot{}
    \rfoot{\thepage/\pageref{LastPage}}
    


    \begin{document}

      \pagestyle{fancy}
      \input{Tex/document-title.tex}
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

      <xsl:for-each select="include/name">
      \input{Tex/<xsl:value-of select="."/>.tex}
      </xsl:for-each>

    \end{document}

  </xsl:template>
  
  <xsl:template name="description">
        \section*{Descrizione del documento}
  </xsl:template>
  
  <xsl:template name="changes">
      \section*{Diario delle modifiche}
      \begin{center}
        \begin{tabu} to \textwidth {|X[c]|X[c]|X[c]|X[c]|X[c]|}
          \hline
          \rowfont{\bf}
          Versione <xsl:text>&amp;</xsl:text>
          Data <xsl:text>&amp;</xsl:text>
          Autore <xsl:text>&amp;</xsl:text>
          Ruolo <xsl:text>&amp;</xsl:text>
          Descrizione \\
          \hline
          <xsl:for-each select="changes/version">
            <xsl:value-of select="id"/> <xsl:text>&amp;</xsl:text>
            <xsl:value-of select="date"/> <xsl:text>&amp;</xsl:text>
            <xsl:value-of select="author"/> <xsl:text>&amp;</xsl:text>
            <xsl:value-of select="role"/> <xsl:text>&amp;</xsl:text>
            <xsl:value-of select="description"/> \\
            \hline
          </xsl:for-each>
        \end{tabu}
      \end{center}
  </xsl:template>
  

</xsl:stylesheet>
