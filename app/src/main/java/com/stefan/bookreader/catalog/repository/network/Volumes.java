package com.stefan.bookreader.catalog.repository.network;


import java.math.BigDecimal;
import java.util.List;

public class Volumes {

    private Volumes(){
        //no instantiation
    }
    private String type;
    private List<Volume> items;

    public List<Volume> getItems() {
        return items;
    }

    public static class Volume{

        private String type;
        private String id;
        private String selfLink;
        private VolumeInfo volumeInfo;

        public String getType() {
            return type;
        }

        public String getId() {
            return id;
        }

        public String getSelfLink() {
            return selfLink;
        }

        public VolumeInfo getVolumeInfo() {
            return volumeInfo;
        }

        public static class VolumeInfo {
            private String title;
            private List<String> authors;
            private String publisher;
            private String publishedDate;
            private String description;
            private Integer pageCount;
            private List<String> categories;
            private BigDecimal averageRating;
            private Integer ratingsCount;
            private ImageLinks imageLinks;

            public String getTitle() {
                return title;
            }

            public List<String> getAuthors() {
                return authors;
            }

            public String getPublisher() {
                return publisher;
            }

            public String getPublishedDate() {
                return publishedDate;
            }

            public String getDescription() {
                return description;
            }

            public String getPageCount() {
                return pageCount!=null?pageCount.toString():null ;
            }

            public List<String> getCategories() {
                return categories;
            }

            public BigDecimal getAverageRating() {
                return averageRating;
            }

            public Integer getRatingsCount() {
                return ratingsCount;
            }

            public ImageLinks getImageLinks() {
                return imageLinks;
            }

            public static class ImageLinks {
                private String smallThumbnail;
                private String thumbnail;

                public String getSmallThumbnail() {
                    return smallThumbnail;
                }

                public String getThumbnail() {
                    return thumbnail;
                }
            }
        }
    }
}
