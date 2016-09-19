import json
import pprint
import matplotlib.pyplot as plt


class DNAAnalyzer(object):
    def __init__(self):
        self.lookup = {
              'ttt': {'code': 'F', 'name': 'Phenylalanine'},
              'ttc': {'code': 'F', 'name': 'Phenylalanine'},
              'tta': {'code': 'L', 'name': 'Leucine'},
              'ttg': {'code': 'L', 'name': 'Leucine'},

              'tct': {'code': 'S', 'name': 'Serine'},
              'tcc': {'code': 'S', 'name': 'Serine'},
              'tca': {'code': 'S', 'name': 'Serine'},
              'tcg': {'code': 'S', 'name': 'Serine'},

              'tat': {'code': 'Y', 'name': 'Tyrosine'},
              'tac': {'code': 'Y', 'name': 'Tyrosine'},
              'taa': {'code': '*', 'name': 'Stop'},
              'tag': {'code': '*', 'name': 'Stop'},

              'tgt': {'code': 'C', 'name': 'Cysteine'},
              'tgc': {'code': 'C', 'name': 'Cysteine'},
              'tga': {'code': '*', 'name': 'Stop'},
              'tgg': {'code': 'W', 'name': 'Typtophan'},

              'ctt': {'code': 'L', 'name': 'Leucine'},
              'ctc': {'code': 'L', 'name': 'Leucine'},
              'cta': {'code': 'L', 'name': 'Leucine'},
              'ctg': {'code': 'L', 'name': 'Leucine'},

              'cct': {'code': 'P', 'name': 'Phenylalanine'},
              'ccc': {'code': 'P', 'name': 'Phenylalanine'},
              'cca': {'code': 'P', 'name': 'Phenylalanine'},
              'ccg': {'code': 'P', 'name': 'Phenylalanine'},

              'cat': {'code': 'H', 'name': 'Hisitidine'},
              'cac': {'code': 'H', 'name': 'Hisitidine'},
              'caa': {'code': 'Q', 'name': 'Glutamine'},
              'cag': {'code': 'Q', 'name': 'Glutamine'},

              'cgt': {'code': 'R', 'name': 'Arginine'},
              'cgc': {'code': 'R', 'name': 'Arginine'},
              'cga': {'code': 'R', 'name': 'Arginine'},
              'cgg': {'code': 'R', 'name': 'Arginine'},

              'att': {'code': 'I', 'name': 'Isoleucine'},
              'atc': {'code': 'I', 'name': 'Isoleucine'},
              'ata': {'code': 'I', 'name': 'Isoleucine'},
              'atg': {'code': 'M', 'name': 'Start'},

              'act': {'code': 'T', 'name': 'Threonine'},
              'acc': {'code': 'T', 'name': 'Threonine'},
              'aca': {'code': 'T', 'name': 'Threonine'},
              'acg': {'code': 'T', 'name': 'Threonine'},

              'aat': {'code': 'N', 'name': 'Asparagine'},
              'aac': {'code': 'N', 'name': 'Asparagine'},
              'aaa': {'code': 'K', 'name': 'Lysine'},
              'aag': {'code': 'K', 'name': 'Lysine'},

              'agt': {'code': 'S', 'name': 'Serine'},
              'agc': {'code': 'S', 'name': 'Serine'},
              'aga': {'code': 'R', 'name': 'Arginine'},
              'agg': {'code': 'R', 'name': 'Arginine'},

              'gtt': {'code': 'V', 'name': 'Valine'},
              'gtc': {'code': 'V', 'name': 'Valine'},
              'gta': {'code': 'V', 'name': 'Valine'},
              'gtg': {'code': 'V', 'name': 'Valine'},

              'gct': {'code': 'A', 'name': 'Alanine'},
              'gcc': {'code': 'A', 'name': 'Alanine'},
              'gca': {'code': 'A', 'name': 'Alanine'},
              'gcg': {'code': 'A', 'name': 'Alanine'},

              'gat': {'code': 'D', 'name': 'Aspartic Acid'},
              'gac': {'code': 'D', 'name': 'Aspartic Acid'},
              'gaa': {'code': 'E', 'name': 'Glutamic Acid'},
              'gag': {'code': 'E', 'name': 'Glutamic Acid'},

              'ggt': {'code': 'G', 'name': 'Glycine'},
              'ggc': {'code': 'G', 'name': 'Glycine'},
              'gga': {'code': 'G', 'name': 'Glycine'},
              'ggg': {'code': 'G', 'name': 'Glycine'}
        }

    def translate(self, sequence):
        seq_len = len(sequence)
        a_count = sequence.count('a')
        c_count = sequence.count('c')
        t_count = sequence.count('t')
        g_count = sequence.count('g')

        protein_sequence = ''

        for i in range(0, seq_len-2, 3):
            protein_sequence = protein_sequence.__add__(
                self.lookup[sequence[i: i + 3]]['code'])

        print protein_sequence
        print 'Frequency and Percentage Table'
        print 'A| ', a_count, '\t|', "{0:.3f}".format(float(a_count)/seq_len)
        print 'C| ', c_count, '\t|', "{0:.3f}".format(float(c_count)/seq_len)
        print 'T| ', t_count, '\t|', "{0:.3f}".format(float(t_count)/seq_len)
        print 'G| ', g_count, '\t|', "{0:.3f}".format(float(g_count)/seq_len)

        x_pos = range(4)
        x = ['A', 'C', 'T', 'G']
        y = [a_count, c_count, t_count, g_count]

        plane, axes = plt.subplots(1)
        axes.bar(x_pos, y, align='center', tick_label=x, fill=False, ec='none')
        axes.plot(x_pos, y)
        axes.plot(x_pos, y, 'ob')
        axes.set_ylim(ymin=0)
        plt.show(plane)


if __name__ == '__main__':
    analyzer = DNAAnalyzer()

    analyzer.translate('atgaagtcagctattttaaccggtttgcttttcgtc')
