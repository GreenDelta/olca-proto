from setuptools import setup, find_packages
from os import path

# Get the long description from the README file
here = path.abspath(path.dirname(__file__))
with open(path.join(here, 'README.md'), encoding='utf-8') as f:
    long_description = f.read()

setup(
    name='protolca',
    version='0.0.1',
    description='A Python package for ...',
    long_description=long_description,
    long_description_content_type='text/markdown',
    url='https://github.com/msrocka/protolca',
    packages=find_packages(
        exclude=["tests", "*.tests", "*.tests.*", "tests.*"]),
    install_requires=['protobuf'],
    include_package_data=True,
    keywords=['openLCA', 'life cycle assessment', 'LCA'],
    classifiers=[
        "Development Status :: 2 - Pre-Alpha",
        "Environment :: Console",
        "Intended Audience :: Science/Research",
        "License :: OSI Approved :: Mozilla Public License 2.0 (MPL 2.0)",
        "Programming Language :: Python :: 3.8",
        "Topic :: Utilities",
    ]
)
