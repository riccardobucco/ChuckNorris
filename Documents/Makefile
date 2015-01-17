DOCUMENTI =	NormeDiProgetto \
		AnalisiDeiRequisiti \
		PianoDiProgetto \
		PianoDiQualifica \
		StudioDiFattibilita

all: $(DOCUMENTI) Glossario


Glossario: FORCE
	@ #validazione schema
	@ xmllint --noout --schema Commons/Document.xsd Glossario/Glossario.xml

	@ #creazione file latex
	@ xsltproc -o Glossario/Glossario.tex Commons/Document.xsl Glossario/Glossario.xml

	@ #validazione schema
	@ xmllint --noout --schema Glossario/Termini.xsd Glossario/Termini.xml

	@ #creazione file latex
	@ xsltproc -o Glossario/Termini.tex Glossario/Termini.xsl Glossario/Termini.xml

	@ #compilazione file latex
	@ make $@/$@.pdf

UseCase: FORCE
	@ find AnalisiDeiRequisiti/UseCase -name '*.xml' | grep -Eo 'UC[0-9](\.[0-9])*' | sort -k 13 |sort -k 11 | sort -k 9 | sort -k 7 | sort -k 5 | sort -k 3 | sed 's/\(^.*$$\)/\1\.xml/g' | xargs -I {} xsltproc AnalisiDeiRequisiti/UseCase/UC.xsl AnalisiDeiRequisiti/UseCase/{} > AnalisiDeiRequisiti/UseCase/UC.tex

$(DOCUMENTI): FORCE
	@ #validazione schema
	@ xmllint --noout --schema Commons/Document.xsd $@/$@.xml

	@ #creazione file latex
	@ xsltproc -o $@/$@.tex Commons/Document.xsl $@/$@.xml

	@ #compilazione file latex
	@ make $@/$@.pdf

%.pdf: FORCE
	@ export TEXINPUTS=":Commons/"; pdflatex -output-directory `dirname $*` `dirname $*`.tex
	@ export TEXINPUTS=":Commons/"; pdflatex -output-directory `dirname $*` `dirname $*`.tex > /dev/null
	@ export TEXINPUTS=":Commons/"; pdflatex -output-directory `dirname $*` `dirname $*`.tex > /dev/null

clean: FORCE
	@ rm -f */*.tex
	@ rm -f */*.out */*.log */*.aux */*.toc */*.lof */*.lot

	@ rm -f AnalisiDeiRequisiti/UseCase/UC.tex

FORCE:
